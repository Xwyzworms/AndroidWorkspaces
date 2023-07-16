/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.tvshow

import com.example.simplemovieapp.presentation.tv.TvActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvActivity: TvActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }
}