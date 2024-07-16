package com.app.idCard.java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppUtils {



    public void convertComposableToPDF(Context context, View view, String pdfName) {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (context instanceof MainActivity) {
                ((MainActivity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                throw new IllegalArgumentException("Context is not an Activity context");
            }
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.EXACTLY)
        );

        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);

        PdfDocument pdfDocument = new PdfDocument();

        int viewHeight = view.getMeasuredHeight();
        int viewWidth = view.getMeasuredWidth();

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        view.draw(canvas);

        pdfDocument.finishPage(page);

        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String fileName = pdfName+".pdf";
        File file = new File(downloadsDir, fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            pdfDocument.writeTo(fos);
            Toast.makeText(context, "PDF Saved Successfully!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("AppUtils", "Error writing PDF", e);
            Toast.makeText(context, "Failed to save PDF", Toast.LENGTH_LONG).show();
        }

        pdfDocument.close();
    }
}
