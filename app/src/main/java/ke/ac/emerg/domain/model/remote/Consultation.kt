package ke.ac.emerg.domain.model.remote

data class Consultation(
    val _id : String,
    val user : String,
    val description : String,
    val status : String,
    val consultationDate : String
){
    companion object{
        fun getConsultations() = listOf(
            Consultation("12", "brian", "hello world", "done", "today")
        )
    }
}
