import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    let appDelegate = AppDelegate()

    init() {
        KoinModuleKt.initializeKoin()
        UIApplication.shared.isIdleTimerDisabled = true
        UIApplication.shared.delegate = appDelegate
    }

	var body: some Scene {
		WindowGroup {
			ContentView().ignoresSafeArea()
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {
    func applicationWillResignActive(_ application: UIApplication) {
       UIApplication.shared.isIdleTimerDisabled = false
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        UIApplication.shared.isIdleTimerDisabled = true
    }

    func applicationWillTerminate(_ application: UIApplication) {
        KoinModuleKt.destroyKoin()
    }
}