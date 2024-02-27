package data

import com.example.seamless.R
import model.Function

class DataSource {
    fun loadFunction(): List<Function>{
        return listOf<Function>(
            Function(R.string.function1, R.drawable.testimage),
            Function(R.string.function2, R.drawable.testimage),
            Function(R.string.function3, R.drawable.testimage),
            Function(R.string.function4, R.drawable.testimage),
            Function(R.string.function5, R.drawable.testimage),
            Function(R.string.function6, R.drawable.testimage),
            Function(R.string.function7, R.drawable.testimage),
            Function(R.string.function8, R.drawable.testimage),
            Function(R.string.function9, R.drawable.testimage),
            Function(R.string.function10, R.drawable.testimage)
        )
    }
}