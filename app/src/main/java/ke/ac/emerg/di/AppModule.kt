package ke.ac.emerg.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ke.ac.emerg.EmergApp
import ke.ac.emerg.domain.ConsultationsAPI
import ke.ac.emerg.domain.repo.ConsultationRepo
import ke.ac.emerg.util.CONSTANTS.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppContext(@ApplicationContext app : Context) : EmergApp{
        return app as EmergApp;
    }

    @Singleton
    @Provides
    fun provideConsultationsApi() : ConsultationsAPI{
        return Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConsultationsAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesConsultationRepository(consultationsAPI: ConsultationsAPI) : ConsultationRepo {
        return ConsultationRepo(consultationsAPI);
    }
}