# RoomDatabase with Livedata

Gradle dependencies  
def room_version = "2.1.0-rc01"  
def lifecycle_version = "2.0.0"  

// Room dependency  
implementation "androidx.room:room-runtime:$room_version"  
annotationProcessor "androidx.room:room-compiler:$room_version"  
// ViewModel and LiveData  
implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"  
// alternatively - just ViewModel  
implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version" // For Kotlin use lifecycle-viewmodel-ktx  
// alternatively - just LiveData  
implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"  

Reference  
Room - https://developer.android.com/topic/libraries/architecture/room  
ViewModel - https://developer.android.com/topic/libraries/architecture/viewmodel  
