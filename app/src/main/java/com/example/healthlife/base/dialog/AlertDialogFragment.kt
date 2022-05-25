package com.example.healthlife.base.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import com.example.healthlife.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


/**
 * 通用的信息提示框类.
 *
 *
 * 重写onCreateView方法可以使用自定义布局，此种模式下则不需要再复写onCreateDialog方法
 * 注意不能在使用Dialog的DialogFragment中使用ViewLifecycleOwner作为LiveData的LifecycleOwner，应该用DialogFragment自己或者NavBackStackEntry
 * @see [https://developer.android.com/guide/fragments/dialogs](DialogFragment)
 *
 */
class AlertDialogFragment : BaseDialog() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        logger.d(TAG, "onCreateDialog Ptt Alert")
        val args: AlertDialogFragmentArgs = AlertDialogFragmentArgs.fromBundle(requireArguments())

        //set dialogFragment cancelable
        isCancelable = args.cancelable
        val builder: MaterialAlertDialogBuilder =
            MaterialAlertDialogBuilder(requireContext(), R.style.Style_UI_AlertDialog)
                .setTitle(args.titleResId)
                .setMessage(args.messageResId)
                .setCancelable(args.cancelable)
                .setPositiveButton(R.string.dialog_btn_ok) { _, _ ->
                    logger.d(TAG, "on click ok")
                    findNavController().navigateUp()
                    setNavigationResult(Button.POSITIVE)
                }

        //set show cancel button or not
        if (args.dialogType !== (Type.SINGLE_BUTTON)) {
            builder.setNegativeButton(R.string.dialog_btn_cancel) { _, _ ->
                logger.d(TAG, "on click cancel")
                findNavController().navigateUp()
                setNavigationResult(Button.NEGATIVE)
            }
        }

        return builder.show()
    }

    override fun onCancel(dialog: DialogInterface) {
        logger.d(TAG, "onCancel")
        setNavigationResult(Button.NEGATIVE)
    }

    /**
     * The enum Type.
     */
    enum class Type {
        /**
         * Default type.
         *
         *
         * 确定+取消按钮
         *
         */
        DEFAULT,

        /**
         * Single button type.
         *
         *
         * 只有确定按钮
         *
         */
        SINGLE_BUTTON
    }

    enum class Button {
        POSITIVE, NEGATIVE
    }

    companion object {
        private const val TAG = "[fragment][dialog][alert]"
    }
}