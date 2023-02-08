package com.example.profilecardlayoutusingcomposes

data class UserProfileDataClass constructor(val id:Int,val name:String,val status:Boolean,val pictureUrl:String)
{

}

val userProfileList= arrayListOf<UserProfileDataClass>(
  UserProfileDataClass(0,"Sundar Pichai",true,"https://i.gadgets360cdn.com/large/sundar_pichai_afp_full_1575545245314.jpg"),
  UserProfileDataClass(1,"Satya Nadella",false,"https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/satya-nadella-sixteen_nine.jpg?size=1200:675"),
  UserProfileDataClass(2,"Mark Zuckerberg",true,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg/330px-Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg"),
  UserProfileDataClass(3,"Elizabeth Holmes",true,"https://i.insider.com/613a08c6a30aeb0018b4a34f?width=700"),
  UserProfileDataClass(4,"Jack Ma",false,"https://feeds.abplive.com/onecms/images/uploaded-images/2022/11/30/41ca4d3ab281feb39804873b37c44446166979719264919_original.jpg?impolicy=abp_cdn&imwidth=650"),
  UserProfileDataClass(5,"Parag Agrawal",true,"https://c.ndtvimg.com/2021-11/g09pdd7k_parag-agrawal-afp_625x300_30_November_21.jpg"),
  UserProfileDataClass(6,"Sarah Friar",false,"https://imageio.forbes.com/specials-images/imageserve/5f77a6772e0d0b68e13fe0f5/0x0.jpg?format=jpg&crop=1246,1245,x686,y89,safe&height=416&width=416&fit=bounds"),
  UserProfileDataClass(7,"Elon Musk",false,"https://cdn.techjuice.pk/wp-content/uploads/2022/11/Elon-Musk-Overworked.jpg"),
  UserProfileDataClass(8,"Ashneer Grover",true,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpFxTgMx317aIdade50TKDtB3IQZXvfGKUf2mCEONB_GZzk08AOTj4puZg7Vah11p2Lvs&usqp=CAU"),
  UserProfileDataClass(9,"Tim Cook",false,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa0W_GYb2Bj6R2R7fnHND0TANE7_JU6ZN1KrBlN_wj6DBnTsdX")
)