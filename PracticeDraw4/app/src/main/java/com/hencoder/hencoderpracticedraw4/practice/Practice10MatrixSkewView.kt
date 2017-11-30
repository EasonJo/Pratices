package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice10MatrixSkewView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    private val mt = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        with(mt) {
            reset()
            preSkew(0f, 0.5f, (point1.x + bitmap.width / 2).toFloat(), (point1.y + bitmap.height / 2).toFloat())
        }
        with(canvas) {
            save()
            concat(mt)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()
        }

        with(mt) {
            reset()
            preSkew(-0.5f, 0f, (point2.x + bitmap.width / 2).toFloat(), (point2.y + bitmap.height / 2).toFloat())
        }
        with(canvas) {
            save()
            concat(mt)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}
