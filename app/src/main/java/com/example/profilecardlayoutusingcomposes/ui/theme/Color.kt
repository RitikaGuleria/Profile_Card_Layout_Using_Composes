package com.example.profilecardlayoutusingcomposes.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val veryLightGray=Color(0x60DCDCDC)
// I will use this my own defined color in theme kotlin class

//To learn how to use our own defined color in mainactivity class using material theme,this should be follow
//we have to make EXTENSION FUNCTION to use our owndefined color
val verylightgreen=Color(0x9932CD32)

val Colors.lightGreen:Color
    @Composable
    get()= verylightgreen
