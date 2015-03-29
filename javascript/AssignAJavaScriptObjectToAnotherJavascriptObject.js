/**
 * Created with JetBrains PhpStorm.
 * User: root
 * Date: 29/3/15
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */

var jsonObj = {
    "name":"gyani",
    "address":"Bangalore India",
    "occupation":"Software Engineer",
    "url":"gyaneshwarpardhi.wordpress.com",
    "friends":[
        {
            "name":"gyani",
            "address":"bangalore",
            "occupation":"Software Engineer",
            "url":"gyaneshwarpardhi.wordpress.com"

        },

        {
            "name":"gyani",
            "address":"Bangalore India",
            "occupation":"Software Engineer",
            "url":"gyaneshwarpardhi.wordpress.com"

        }
    ],
   "contacts":{
      'email':"gyaan1334@gmail.com",
       "skype":"gyaan1334"

   }
}


var jsonObj2={};

copyFromOneJsonToAnotherJson(jsonObj,jsonObj2);

jsonObj.name="hello changed name";

console.log(jsonObj2);

//dude this is not assigned by reference  so jsonObj will be as it is
console.log(jsonObj);


//function to copy one json object to anther
function copyFromOneJsonToAnotherJson(fromJson,toJson){

    for(var key in fromJson){

        if(fromJson.hasOwnProperty(key)){

            if(Array.isArray(fromJson[key])){

                if(fromJson[key] instanceof Array){
                    toJson[key]=[];
                }
                else{
                    toJson[key]={};
                }

                toJson[key]=copyFromOneJsonToAnotherJson(fromJson[key],toJson[key]);

            }
            else{
                toJson[key]=fromJson[key];
            }
        }
    }

    return toJson;
}
