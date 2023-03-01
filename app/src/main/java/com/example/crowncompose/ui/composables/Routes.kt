package com.example.crowncompose.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.crowncompose.R

interface CrownRoutes {
    val icon: ImageVector
    val name: Int
    val route: String
    var badgeCount: Int
    val screen: @Composable () -> Unit
}

object WhatsOn : CrownRoutes {
    override val icon: ImageVector = Icons.Filled.Warning
    override val name: Int = R.string.nav_screen_whatson
    override val route: String = "whatson"
    override var badgeCount: Int = 0
    override val screen: @Composable () -> Unit = { WhatsOnScreen() }
}

object Rewards : CrownRoutes {
    override val icon: ImageVector = Icons.Filled.Share
    override val name: Int = R.string.nav_screen_rewards
    override val route: String = "rewards"
    override var badgeCount: Int = 1
    override val screen: @Composable () -> Unit = { RewardsScreen() }
}

object Notification : CrownRoutes {
    override val icon: ImageVector = Icons.Filled.Email
    override val name: Int = R.string.nav_screen_notification
    override val route: String = "notification"
    override var badgeCount: Int = 3
    override val screen: @Composable () -> Unit = { NotificationScreen() }
}

object Details : CrownRoutes {
    override val icon: ImageVector = Icons.Filled.Settings
    override val name: Int = R.string.nav_screen_details
    override val route: String = "details"
    override var badgeCount: Int = 0
    override val screen: @Composable () -> Unit = {
        DetailsScreen {}
    }
}

val navItems = listOf(WhatsOn, Rewards, Notification, Details)