/*------------------------------------------------------------------------------
 **    Author: René de Groot
 ** Copyright: (c) 2017 René de Groot All Rights Reserved.
 **------------------------------------------------------------------------------
 ** No part of this file may be reproduced
 ** or transmitted in any form or by any
 ** means, electronic or mechanical, for the
 ** purpose, without the express written
 ** permission of the copyright holder.
 *------------------------------------------------------------------------------
 *
 *   This file is part of "Stay-awake on adb".
 *
 *   "Stay-awake on adb" is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   "Stay-awake on adb" is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with "Stay-awake on adb".  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package nl.renedegroot.android.adbawake.about

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import nl.renedegroot.android.adbawake.R
import nl.renedegroot.android.adbawake.bindings.CommonBindingComponent
import nl.renedegroot.android.adbawake.databinding.FragmentAboutBinding

/**
 * Show a little HTML with licenses and version info
 */
class AboutFragment : DialogFragment() {

    val model = AboutViewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var binding = DataBindingUtil.inflate<FragmentAboutBinding>(activity.layoutInflater, R.layout.fragment_about, null, false, CommonBindingComponent())
        binding.model = model

        val builder = AlertDialog.Builder(activity)
        builder.setView(binding.root)
        builder.setPositiveButton(android.R.string.ok) { dialog, which -> removeAbout() }

        return builder.create()
    }

    fun removeAbout() {
        dismiss()
    }
}