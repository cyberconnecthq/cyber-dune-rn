package com.cyber.cyberdune.viewmodel

import com.cyberconnect.link3.fragment.Price
import com.cyberconnect.link3.type.PersonalDisplayName_Type

data class UserProfile(
    val accessToken: String? = "",
    val walletAddress: String? = "",
    val userId: String = "",
    val subOrgId: String = "",
)

val DefaultUserProfile = UserProfile()
