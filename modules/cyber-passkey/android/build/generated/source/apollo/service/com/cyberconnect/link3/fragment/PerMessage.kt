//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import com.cyberconnect.link3.type.MessageStatus
import com.cyberconnect.link3.type.MessageType
import com.cyberconnect.link3.type.PaidStatus
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class PerMessage(
  public val content: String,
  public val id: String,
  public val msgType: MessageType,
  public val paid: Paid,
  public val sender: Sender,
  public val chatUser: ChatUser,
  public val msgTime: Int,
  public val replyToEarn: Boolean,
  public val status: MessageStatus,
) : Fragment.Data {
  public data class Paid(
    public val earnValue: EarnValue?,
    public val status: PaidStatus,
    public val `value`: Value?,
    public val refundAt: Int?,
  )

  public data class Sender(
    public val lightInfo: LightInfo,
  )

  public data class ChatUser(
    public val lightInfo: LightInfo1,
  )

  public data class EarnValue(
    public val __typename: String,
    /**
     * Synthetic field for 'Price'
     */
    public val price: Price,
  )

  public data class Value(
    public val __typename: String,
    /**
     * Synthetic field for 'Price'
     */
    public val price: Price,
  )

  public data class LightInfo(
    public val displayName: String,
    public val handle: String,
    public val avatar: String,
  )

  public data class LightInfo1(
    public val displayName: String,
    public val handle: String,
    public val avatar: String,
  )
}
