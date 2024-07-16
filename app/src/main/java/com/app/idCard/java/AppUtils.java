package com.app.idCard.java;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.app.idCard.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class AppUtils {

    public void makeToast(Context context) {
        Toast.makeText(context, "Kotlin button pressed", Toast.LENGTH_LONG).show();
    }

    public void convertXMLToPDF(Context context) {
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Context is not an Activity context");
        }

        Activity activity = (Activity) context;
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Objects.requireNonNull(context.getDisplay()).getRealMetrics(displayMetrics);
        } else {
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
        }

        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);

        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(view.getMeasuredWidth(), view.getMeasuredHeight(), 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        view.draw(canvas);
        pdfDocument.finishPage(page);

        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadsDir, "Example3.pdf");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            pdfDocument.writeTo(fos);
            Toast.makeText(context, "PDF Saved Successfully!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("AppUtils", "Error while writing PDF", e);
            throw new RuntimeException("Error while writing PDF", e);
        } finally {
            pdfDocument.close();
        }
    }
}
