package com.example.myweather.utils

import android.content.Context
import com.example.myweather.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.showSimpleListDialog(
    title: String,
    items: List<String>,
    onItemClicked: (Int) -> Unit
) {
    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setItems(items.toTypedArray()) { dialog, selectedIndex ->
            dialog.dismiss()
            onItemClicked.invoke(selectedIndex)
        }
        .show()
}

fun showCustomAlertDialogOneButton(
    context: Context,
    title: String? = null,
    message: String? = null,
    positive: String? = null,
    positiveListener: (() -> Unit)? = null,
    isCancelable: Boolean = false,
) {
    val dialog = MaterialAlertDialogBuilder(context)
        .setTitle(
            if (title.isNullOrBlank()) context.getString(R.string.label_information)
            else title
        )
        .setMessage(message.orEmpty())
        .setPositiveButton(
            if (positive.isNullOrBlank()) context.getString(R.string.action_oke)
            else positive
        ) { dialog, _ ->
            dialog.dismiss()
            positiveListener?.invoke()
        }
        .setCancelable(isCancelable)
    dialog.show()
}
