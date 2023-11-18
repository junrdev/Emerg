package ke.ac.emerg.domain.repo

import ke.ac.emerg.domain.ConsultationsAPI
import ke.ac.emerg.domain.model.remote.Consultation
import ke.ac.emerg.util.DataWrapper
import javax.inject.Inject

class ConsultationRepo @Inject constructor(private val consultationsAPI: ConsultationsAPI) {


    private val data = DataWrapper<ArrayList<Consultation>>()

    suspend fun getConsultations() :DataWrapper<ArrayList<Consultation>>{
        try {
            data.data = consultationsAPI.getConsultations()
        }catch (e : Exception) {
            throw e
        }
        return data;
    }


}