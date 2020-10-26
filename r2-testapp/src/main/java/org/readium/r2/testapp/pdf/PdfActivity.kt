/*
 * Copyright (c) 2020. Readium Foundation. All rights reserved.
 * Use of this source code is governed by a BSD-style license which is detailed in the
 * LICENSE file present in the project repository where this source code is maintained.
 */

package org.readium.r2.testapp.pdf

import android.os.Bundle
import org.readium.r2.navigator.pdf.R2PdfActivity
import org.readium.r2.shared.PdfSupport
import org.readium.r2.shared.publication.Locator
import org.readium.r2.testapp.db.BooksDatabase

@OptIn(PdfSupport::class)
class PdfActivity : R2PdfActivity() {

    private var bookId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bookId = intent.getLongExtra("bookId", -1)
    }

    override fun onCurrentLocatorChanged(locator: Locator) {
        val books = BooksDatabase(this).books
        books.saveProgression(locator, bookId)
    }

}