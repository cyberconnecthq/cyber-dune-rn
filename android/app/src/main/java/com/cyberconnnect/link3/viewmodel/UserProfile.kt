package com.cyber.cyberdune.viewmodel

import com.cyberconnnect.link3.fragment.Price
import com.cyberconnnect.link3.type.PersonalDisplayName_Type

data class UserProfile(
    val accessToken: String? = "",
    val walletAddress: String? = "",
    val userId: String = "",
    val subOrgId: String = "",
)

val DefaultUserProfile = UserProfile()
