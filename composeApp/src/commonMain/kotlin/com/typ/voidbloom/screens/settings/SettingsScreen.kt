package com.typ.voidbloom.screens.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.agePreference
import voidbloom.composeapp.generated.resources.aiEngineAPIKey
import voidbloom.composeapp.generated.resources.aiEngineBackend
import voidbloom.composeapp.generated.resources.aiEngineBackendGemini
import voidbloom.composeapp.generated.resources.apiKeyIsSecret
import voidbloom.composeapp.generated.resources.descRegular
import voidbloom.composeapp.generated.resources.grownup
import voidbloom.composeapp.generated.resources.headerMsgSettingsScreen
import voidbloom.composeapp.generated.resources.stylePreference

object SettingsScreen : BaseActionScreen(HomeAction.Settings.hashCode()) {


    @Composable
    override fun Content() {
        val agePreference = Res.string.grownup.string()
        val stylePreference = Res.string.descRegular.string()
        val aiBackend = Res.string.aiEngineBackendGemini.string()
        val secret = Res.string.apiKeyIsSecret.string()

        ScreenLazyColumn {
            headerMessage(Res.string.headerMsgSettingsScreen)

            item { VSpacer(36.dp) }

            agePreferenceCard(agePreference) {}
            stylePreferenceCard(stylePreference) {}
            aiBackendCard(aiBackend) {}
            engineApiKeyCard(secret) {}
        }
    }

    private fun LazyListScope.settingsPreferenceCard(
        title: StringResource,
        value: String,
        onClick: () -> Unit,
    ) {
        item {
            SettingsCard(
                title = title.string(),
                value = value,
                onClick = onClick,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .animateItem(),
            )
        }
    }

    private fun LazyListScope.agePreferenceCard(value: String, onClick: () -> Unit) {
        settingsPreferenceCard(
            title = Res.string.agePreference,
            onClick = onClick,
            value = value,
        )
    }

    private fun LazyListScope.stylePreferenceCard(value: String, onClick: () -> Unit) {
        settingsPreferenceCard(
            title = Res.string.stylePreference,
            onClick = onClick,
            value = value,
        )
    }

    private fun LazyListScope.aiBackendCard(value: String, onClick: () -> Unit) {
        settingsPreferenceCard(
            title = Res.string.aiEngineBackend,
            onClick = onClick,
            value = value,
        )
    }

    private fun LazyListScope.engineApiKeyCard(value: String, onClick: () -> Unit) {
        settingsPreferenceCard(
            title = Res.string.aiEngineAPIKey,
            onClick = onClick,
            value = value,
        )
    }

}

@Preview
@Composable
private fun SettingsScreenPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        SettingsScreen.Content()
    }
}
