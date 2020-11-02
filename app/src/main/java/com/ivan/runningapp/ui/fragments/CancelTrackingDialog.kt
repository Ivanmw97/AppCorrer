package com.ivan.runningapp.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ivan.runningapp.R

class CancelTrackingDialog : DialogFragment() {

    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: () -> Unit) {
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel run?")
            .setMessage("Are you sure to cancel de run?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("yes") {_, _ ->
                yesListener?.let { yes ->
                    yes()
                }
            }
            .setNegativeButton("No") {dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }
}