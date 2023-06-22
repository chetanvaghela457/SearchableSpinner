# SearchableSpinner

![Demo SearchableSpinner](https://github.com/chetan532/SearchableSpinner/blob/main/video/demo.gif) 

## Usage

Add the dependency to your build.gradle.
```xml
dependencies {
	        implementation 'com.github.chetan532:SearchableSpinner:1.0.0'
	}
```

```xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


Usage on layout
```xml

<com.cvaghela.spinner.searchablespinner.SearchableSpinner
        android:id="@+id/searchableSpinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginRight="24dp"
        android:gravity="center_horizontal"
        app:ItemsDivider="@drawable/divider_item"
        app:DividerHeight="0.5dp"
        app:SearchViewBackgroundColor="@color/black"
        app:SearchHintText="Search Item"
        app:SearchViewHintColor="@color/gray_200"
        app:SearchViewTextColor="@color/white"
        app:SearchCornerRadius="7dp"
        app:SearchViewElevation="5dp"
        app:ListItemColor="@color/white"
        app:DropDownViewCornerRadius="15dp"
        app:MainEntryText="Touch to select"
        app:DropDownMainTextColor="@color/black"
        app:SpinnerExpandHeight="250dp" />

```
