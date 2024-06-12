import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import com.rvcoding.pedropeapp.App
import platform.UIKit.UIApplication
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.UIWindow

fun MainViewController() = ComposeUIViewController {
    LaunchedEffect(Unit) { setStatusBarStyle() }
    App()
}

private fun setStatusBarStyle() {
    val window = UIApplication.sharedApplication.windows.firstOrNull() as? UIWindow
    val rootViewController = window?.rootViewController
    rootViewController?.view?.window?.overrideUserInterfaceStyle = UIUserInterfaceStyle.UIUserInterfaceStyleDark
}