package com.eidarulu.findme.data

import androidx.annotation.DrawableRes
import com.eidarulu.findme.R

data class MatchProfile(
    val name: String,
    @DrawableRes val drawableResId: Int,
)

val profiles = listOf(
    MatchProfile("Andrew Jenkins, 27", R.drawable.andrew_jenkins),
    MatchProfile("Abigail Simmons, 23", R.drawable.abigail_simmons),
    MatchProfile("Joshua Perry, 31", R.drawable.joshua_perry),
    MatchProfile("Lily Anderson, 26", R.drawable.lily_anderson),
    MatchProfile("Logan Russell, 26", R.drawable.logan_russell),
    MatchProfile("Hannah Murphy, 27", R.drawable.hannah_murphy),
    MatchProfile("Alexandra, 22", R.drawable.alexandra),
    MatchProfile("Jacob Foster, 30", R.drawable.jacob_foster),
    MatchProfile("Jackson Carter, 25", R.drawable.jackson_carter),
)