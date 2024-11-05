package com.example.internetslider

import java.io.Serializable

class WebContainer(val name: String, val image: Int, val url: String) :Serializable {
    companion object {
        val webContainer = mutableListOf(
            WebContainer("Картинки", R.drawable.image, "http://ya.ru/images"),
            WebContainer("Музыка", R.drawable.music, "https://music.yandex.ru/"),
            WebContainer("Видео", R.drawable.video, "http://ya.ru/video")
        )
    }
}