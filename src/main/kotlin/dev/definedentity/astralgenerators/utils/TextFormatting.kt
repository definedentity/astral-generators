package dev.definedentity.astralgenerators.utils

import com.google.common.base.CaseFormat
import java.util.Locale

object TextFormatting {
    /** ControllerBlock -> controller_block */
    fun toLowerCaseUnder(string: String): String {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string)
    }

    /** controller_block.legacy -> Controller Block (Legacy) */
    fun toEnglishName(name: Any): String {
        return name.toString().lowercase(Locale.ROOT).split("_").joinToString(" ") {
            it.replaceFirstChar { char -> char.uppercase() }
        }
    }
}
