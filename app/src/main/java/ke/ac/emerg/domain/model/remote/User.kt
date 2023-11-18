package ke.ac.emerg.domain.model.remote

data class User(
    val __v: Int,
    val _id: String,
    val dateJoined: String,
    val email: String,
    val isActive: Boolean,
    val phoneNumber: String,
    val registrationNumber: String
)