package data

import com.example.seamless.R
import model.Function

class DataSource {
    fun loadFunction(functionNumber: Number): List<Function>{ // 0 for main, 1 for personal, 2 for business
        if(functionNumber == 0)
        {
            return listOf<Function>(
                Function(R.string.function1, R.drawable.testimage),
                Function(R.string.function2, R.drawable.testimage)
            )
        }

        if(functionNumber == 1)
        {
            return listOf<Function>(
                Function(R.string.function3, R.drawable.testimage),
                Function(R.string.function4, R.drawable.testimage),
                Function(R.string.function5, R.drawable.testimage)
            )
        }

        if(functionNumber == 2)
        {
            return listOf<Function>(
                Function(R.string.function6, R.drawable.testimage),
                Function(R.string.function7, R.drawable.testimage),
                Function(R.string.function8, R.drawable.testimage),
                Function(R.string.function9, R.drawable.testimage),
                Function(R.string.function10, R.drawable.testimage)
            )
        }

        else
        {
            return listOf<Function>(
                Function(R.string.function0, R.drawable.testimage)
            )
        }

    }
}