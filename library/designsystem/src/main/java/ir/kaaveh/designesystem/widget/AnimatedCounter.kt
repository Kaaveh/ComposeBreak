package ir.kaaveh.designesystem.widget

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ir.kaaveh.designesystem.ThemePreviews
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(
    count: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = 30.sp,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = FontWeight.Bold,
    fontFamily: FontFamily? = FontFamily.Monospace,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    var oldCount by remember {
        mutableStateOf(count)
    }
    SideEffect {
        oldCount = count
    }
    Row(modifier = modifier) {
        val oldCountString = oldCount
        for (i in count.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = count[i]
            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                count[i]
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    slideInVertically { -it } with slideOutVertically { it }
                }, label = ""
            ) { char ->
                Text(
                    text = char.toString(),
                    modifier = modifier,
                    color = color,
                    fontSize = fontSize,
                    fontStyle = fontStyle,
                    fontWeight = fontWeight,
                    fontFamily = fontFamily,
                    letterSpacing = letterSpacing,
                    textDecoration = textDecoration,
                    textAlign = textAlign,
                    lineHeight = lineHeight,
                    overflow = overflow,
                    softWrap = softWrap,
                    maxLines = maxLines,
                    onTextLayout = onTextLayout,
                    style = style,
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun AnimatedCounterPrev() {
    ComposeBreakTheme {
        Surface {
            AnimatedCounter(count = "24")
        }
    }
}