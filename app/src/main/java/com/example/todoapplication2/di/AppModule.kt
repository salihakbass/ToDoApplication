package com.example.todoapplication2.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication2.data.datasource.NotDataSource
import com.example.todoapplication2.data.repository.NotRepository
import com.example.todoapplication2.room.NotDao
import com.example.todoapplication2.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotDataSource(ndao: NotDao): NotDataSource {
        return NotDataSource(ndao)
    }

    @Provides
    @Singleton
    fun provideNotRepository(nds: NotDataSource): NotRepository {
        return NotRepository(nds)
    }

    @Provides
    @Singleton
    fun provideNotDao(@ApplicationContext context: Context): NotDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "notlar.sqlite")
            .createFromAsset("notlar.sqlite").build()
        return vt.getNotDao()
    }

}