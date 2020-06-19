package com.app.bhaskar.easypaisa.di.components

import com.app.bhaskar.easypaisa.application.MyApp
import com.app.bhaskar.easypaisa.mvp.presenter.*
import com.pa.di.modules.DatabaseModule
import com.pa.di.modules.PostRepoModule
import com.pa.di.modules.RemoteDataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DatabaseModule::class, RemoteDataModule::class, PostRepoModule::class))
interface AppComponent {

    fun inject(myApp: MyApp)
    fun inject(myApp: LoginPresenterImpl)

}