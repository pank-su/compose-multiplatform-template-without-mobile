import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Web"

@Composable fun MainView() = App()


@Composable
fun AppPreview() {
    App()
}