package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice05ComposeShaderView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
        val battman = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val battmanLogo = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)


        val batmanShader = BitmapShader(battman, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val batmanShaderLogo = BitmapShader(battmanLogo, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val composeShader = ComposeShader(batmanShader, batmanShaderLogo, PorterDuff.Mode.DST_IN)
        paint.shader = composeShader


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}
