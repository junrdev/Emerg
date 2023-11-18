package ke.ac.emerg.di

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.ac.emerg.domain.model.remote.Consultation
import ke.ac.emerg.domain.repo.ConsultationRepo
import ke.ac.emerg.util.DataWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsultationViewModel @Inject constructor(private val consultationRepo: ConsultationRepo) :
    ViewModel() {

    private val TAG = "ConsultationViewModel"


    private val consultations: MutableState<DataWrapper<ArrayList<Consultation>>> = mutableStateOf(DataWrapper(null))

    val consultationList = consultations.value.data

    init {
        getConsultations()
    }

    private fun getConsultations() {
        viewModelScope.launch(Dispatchers.IO) {
            consultationRepo.getConsultations().let {
                if (it.toString().isNotEmpty()) {
                    consultations.value = it
                    Log.d(TAG, "getConsultations: $it")
                }
            }
        }
    }
}