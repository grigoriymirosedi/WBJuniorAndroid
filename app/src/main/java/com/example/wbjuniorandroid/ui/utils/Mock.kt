package com.example.wbjuniorandroid.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.wbjuniorandroid.R
import kotlin.random.Random

data class CodeRegion(
    val title: String,
    @DrawableRes val icon: Int,
    val prefix: String,
)

data class MoreItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val route: String
)

data class Event(
    val eventURL: String,
    val title: String,
    val place: String,
    val tags: List<String>,
    val passed: Boolean = false
)

data class Community(
    val communityURL: String,
    val title: String,
    val followers: String
)

object Mock {
    val description: String = LoremIpsum(300).values.first()
    val username: String = "Иван Иванов"
    val userPhoneNumber: String = "+7 999 999-99-99"
    val place: String = "13.09.2024 — Москва, ул. Громова, 4"
    val tags: List<String> = listOf("Python", "Kotlin", "Java")
    val eventURL: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIs-9IrXb1_0htSOE1hUcONujC0CoFeVOctg&s"
    val borderImageURL: String = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    val communityImageURL: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaR8vHWWeFISqxLrxNosiOpbyfVlHvRS1SDbRG6QQXM4P7jyumpi456Kz4Yj1xw5E3ufI&usqp=CAU"
    val communityTitle: String = "Designa"
    val meetingtitle: String = "Developer meeting"
    val communityFollowers: String = "10 000 человек"
    val profileImageURL: String = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"

    val mapImageURL: String = "https://s3-alpha-sig.figma.com/img/a7d0/b7a1/73dfa50190eed292a52792c6d52bb4be?Expires=1721001600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jQsCyw2y9CdTII3bcWIKM447zOxnAXzMO~oF1zLuMc4a50o-LDTWjLQ6O4O-SYAwco4S2M73Hp3bge-LhRQsiyphzorG6uQ~Ltc4nSq7-CO84aLefcFKe~QuWNAFE-TGjv2Llss3jbXGDuPiWcCxKGS9WiueJPegmSN9I9OHrHAtzSAeMc-jbKTv-DW8WOyH03GErEOinUUQyrZCQk1-xci7vmSAfnL5NTIpEKRlj114C52DdMoIre~xyF7UeZetOIi1ZTrDZwQ4xERYD3L1a9fS4~qK1bHdACB3Haf6sLkF9NIWx1m15I7J4jmxfDeAiFM-awoIQZ0OAXVSgBNuGg__"

    val name: String = "Иван"
    val secondName: String = "Иванов"

    val codeRegionList = listOf(
        CodeRegion(title = "Россия", icon = R.drawable.ic_ru, prefix = "+7"),
        CodeRegion(title = "Беларусь", icon = R.drawable.ic_by, prefix = "+375"),
        CodeRegion(title = "Казахстан", icon = R.drawable.ic_kz, prefix = "+7"),
        CodeRegion(title = "Армения", icon = R.drawable.ic_am, prefix = "+374"),
        CodeRegion(title = "Киргизия", icon = R.drawable.ic_kg, prefix = "+996"),
        CodeRegion(title = "Узбекистан", icon = R.drawable.ic_uz, prefix = "+998"),
        CodeRegion(title = "Южная корея", icon = R.drawable.ic_kr, prefix = "+82"),
        CodeRegion(title = "Великобритания", icon = R.drawable.ic_gb, prefix = "+44"),
        CodeRegion(title = "Грузия", icon = R.drawable.ic_ge, prefix = "+995"),
        CodeRegion(title = "Турция", icon = R.drawable.ic_tr, prefix = "+90"),
        CodeRegion(title = "США", icon = R.drawable.ic_us, prefix = "+1"),
        CodeRegion(title = "ОАЭ", icon = R.drawable.ic_ae, prefix = "+971"),
        CodeRegion(title = "Китай", icon = R.drawable.ic_cn, prefix = "+86"),
    )

    // TODO: change other routes
    val moreItemsList = listOf(
        MoreItem(icon = R.drawable.ic_more_coffee, title = R.string.more_my_events, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_theme, title = R.string.more_theme, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_notifications, title = R.string.more_notifications, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_security, title = R.string.more_security, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_storage, title = R.string.more_storage, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_support, title = R.string.more_support, route = "myevents"),
        MoreItem(icon = R.drawable.ic_more_invite_friend, title = R.string.more_invite_friend, route = "myevents"),
    )

    val allEventsList = List(20) { Event(eventURL = eventURL, title = meetingtitle, place = place, tags = tags, passed = Random.nextBoolean()) }

    val passedEventsList = allEventsList.map { it.copy(passed = true) }

    val communityList = List(30) { Community(communityURL = communityImageURL, title = communityTitle, followers = communityFollowers)}
}