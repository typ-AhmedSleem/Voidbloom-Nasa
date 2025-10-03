package com.typ.voidbloom.common.ui.components

import KottieAnimation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.VbRes
import com.typ.voidbloom.common.ui.theme.VbShapes
import contentScale.ContentScale
import kotlinx.coroutines.delay
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
@OptIn(ExperimentalResourceApi::class)
fun KottieAnimationView(
    lottieFilenameInVbRes: String,
    speed: Float = 1f,
    iterations: Int = 1,
    restartOnPlay: Boolean = false,
    reverseOnRepeat: Boolean = false,
    backgroundColor: Color = Color.Transparent,
    animationContentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier,
    afterFinishDelay: Long = 0,
    onAnimationCompleted: () -> Unit,
) {
    var animation by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        animation = VbRes.readBytes("files/${lottieFilenameInVbRes}").decodeToString()
    }

    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = composition,
        iterations = iterations,
        speed = speed,
        restartOnPlay = restartOnPlay,
        reverseOnRepeat = reverseOnRepeat,
    )

    CenteredBox(
        modifier = Modifier
            .clip(VbShapes.extraLarge)
            .background(backgroundColor)
            .then(modifier),
    ) {
        KottieAnimation(
            modifier = Modifier.fillMaxSize(),
            progress = { animationState.progress },
            backgroundColor = backgroundColor,
            contentScale = animationContentScale,
            composition = composition,
        )
    }

    LaunchedEffect(key1 = animationState.isCompleted) {
        if (animationState.isCompleted) {
            delay(afterFinishDelay)
            onAnimationCompleted()
        }
    }
}