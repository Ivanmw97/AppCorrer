package com.ivan.runningapp.di

import android.content.Context
import androidx.room.Room
import com.ivan.runningapp.db.RunningDataBase
import com.ivan.runningapp.others.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDataBase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDAO(db: RunningDataBase) = db.getRunDAO()
}