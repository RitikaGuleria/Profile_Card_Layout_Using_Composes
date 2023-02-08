package com.example.profilecardlayoutusingcomposes

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.example.profilecardlayoutusingcomposes.ui.theme.ProfileCardLayoutUsingComposesTheme
import com.example.profilecardlayoutusingcomposes.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ProfileCardLayoutUsingComposesTheme{
                UserApplication()
            }
        }
    }
}

@Composable
fun UserApplication(userProfiles:List<UserProfileDataClass> =userProfileList)
{
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="user_list"){
        composable("user_list"){
            MainScreen(userProfiles,navController)
        }
        composable(route="user_detail/{userId}", arguments = listOf(navArgument("userId"){
            type= NavType.IntType }))
        { navBackStackEntry-> //by doing this, we have access of all the arguments of this above composable
            UserDetailScreen(navBackStackEntry.arguments!!.getInt("userId"),navController)
        }
    }
}

@Composable
fun MainScreen(userProfiles:List<UserProfileDataClass>,navController:NavHostController?)
{
    Scaffold(topBar = {AppBar(title="Users List",icon=Icons.Default.Home){} })
    {
        Surface(modifier=Modifier.fillMaxSize())
        {
            LazyColumn{
                items(userProfiles){
                    userProfile->
                    ProfileCard(userProfile = userProfile){
                        navController?.navigate("user_detail/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar(title:String,icon:ImageVector,iconClickAction:()->Unit)
{
    TopAppBar(navigationIcon = { icon},modifier=Modifier.clickable { iconClickAction.invoke() }
        , title = { Text(text = title)})
}


@Composable
fun ProfileCard(userProfile:UserProfileDataClass,clickAction:()->Unit)
{
    Card(modifier= Modifier
        .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 2.dp)
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.Top)
        .clickable { clickAction.invoke() },
        elevation = 8.dp,
        backgroundColor = Color.White)
    {
       Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement =Arrangement.Start ,
           verticalAlignment = Alignment.CenterVertically)
       {
           ProfilePicture(userProfile.pictureUrl,userProfile.status,72.dp)
           ProfileContent(userProfile.name,userProfile.status,Alignment.Start)
       }
    }
}

@Composable
fun ProfilePicture(pictureUrl:String,onlineStatus:Boolean,ImageSize: Dp)
{
    Card(shape= CircleShape,
        border = BorderStroke(4.dp,color=if(onlineStatus) MaterialTheme.colors.lightGreen
            else Color.LightGray
        ), modifier=Modifier.padding(16.dp), elevation = 4.dp)
    {
        Image(painter =rememberImagePainter(data=pictureUrl),contentScale = ContentScale.Crop, contentDescription ="",
            modifier= Modifier.size(ImageSize))
    }
}

@Composable
fun ProfileContent(name:String,onlineStatus: Boolean,aligment:Alignment.Horizontal)
{
    Column(modifier= Modifier
        .padding(8.dp), horizontalAlignment = aligment)
    {
        CompositionLocalProvider(LocalContentAlpha provides
                if(onlineStatus) 1f else
                ContentAlpha.medium) {
            Text(text = name, style = MaterialTheme.typography.h5)
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = if(onlineStatus) "Active now" else "Offline",style=MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun UserDetailScreen(userId:Int,navController: NavHostController?)
{
    val userProfile= userProfileList.first{ userProfile -> userId == userProfile.id}

    Scaffold(topBar = {AppBar(title="User Profile Detail",icon=Icons.Default.ArrowBack){
        navController?.navigateUp()
    } })
    {
        Surface(modifier=Modifier.fillMaxSize())
        {
            Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
                {
                    ProfilePicture(userProfile.pictureUrl,userProfile.status,250.dp)
                    ProfileContent(userProfile.name,userProfile.status, aligment = Alignment.CenterHorizontally)
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardLayoutUsingComposesTheme{
        MainScreen(userProfiles = userProfileList,null)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ProfileCardLayoutUsingComposesTheme{
        UserDetailScreen(userId = 0,null)
    }
}