package ke.ac.emerg.di

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.ac.emerg.domain.repo.ConsultationRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConsultationViewModel (private val consultationRepo: ConsultationRepo) : ViewModel() {

    private val TAG = "ConsultationViewModel"


    private fun getConsultations() {
        viewModelScope.launch(Dispatchers.IO) {
            consultationRepo.getConsultations().let {
                if (it.toString().isNotEmpty()) {
                    Log.d(TAG, "getConsultations: $it")
                }
            }
        }
    }
}