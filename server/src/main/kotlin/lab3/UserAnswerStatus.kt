package lab3

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserAnswerStatus(
    @SerializedName("RightAnswer")
    val rightAnswer: Boolean
)
