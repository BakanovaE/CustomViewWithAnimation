package org.martellina.customviewanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.martellina.customviewanimation.databinding.CustomViewFragmentBinding

class CustomViewFragment : Fragment() {

    private lateinit var binding: CustomViewFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = CustomViewFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMartin()
        setUpRowling()
        setUpSchildt()
    }

    private fun setUpMartin() {
        binding.martin.populate(
            CustomViewModel(
                "G. R. R. Martin",
                "A Game of Thrones",
                R.drawable.martin,
                GenreName.FANTASY,
                AnimationModel(
                    AnimationType.HIGH,
                    true,
                    200
                )
            )
        )
    }

    private fun setUpRowling() {
        binding.rowling.populate(
            CustomViewModel(
                "J. K. Rowling",
                "Harry Potter",
                R.drawable.rowling,
                GenreName.NON_FIC,
                AnimationModel(
                    AnimationType.MEDIUM,
                    true,
                    400
                )
            )
        )
    }

    private fun setUpSchildt() {
        binding.schildt.populate(
            CustomViewModel(
                "H. Schildt",
                "Java. A Beginner`s Guide",
                R.drawable.schildt,
                GenreName.SCIENCE_FIC,
                AnimationModel(
                    AnimationType.LOW,
                    true,
                    100
                )
            )
        )
    }
}
