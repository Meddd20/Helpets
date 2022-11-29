package id.med.helpets.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import id.med.helpets.R
import id.med.helpets.databinding.FragmentDashboardBinding
import id.med.helpets.ui.createpost.CreatePostActivity

class DashboardFragment : Fragment() {

private var _binding: FragmentDashboardBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDashboardBinding.inflate(inflater, container, false)

    return binding.root
  }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingButton.setOnClickListener {
          it.findNavController().navigate(R.id.action_navigation_favorite_to_createPostActivity2)
        }
    }


override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}