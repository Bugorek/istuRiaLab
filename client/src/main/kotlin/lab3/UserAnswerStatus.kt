package lab3

import com.google.gson.annotations.SerializedName

data class UserAnswerStatus(
    @SerializedName("RightAnswer")
    val rightAnswer: Boolean
)
