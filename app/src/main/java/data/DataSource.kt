package data

import com.example.seamless.R
import model.Function

class DataSource {
    fun loadFunction(): List<Function>{
        return listOf<Function>(
            Function(R.string.function1, R.drawable.testimage),
            Function(R.string.function2, R.drawable.testimage),
        )
    }
}