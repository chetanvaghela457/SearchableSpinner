# SearchableSpinner

The Searchable Spinner is an Android library designed to enhance the user experience by providing a searchable dropdown spinner UI component. It offers a customizable and intuitive way for users to select options from a dropdown list, making it easy to find and select items even in large datasets. The library allows for efficient filtering of options based on user input, enabling smooth navigation through long lists. With its seamless integration into your Android projects, the Searchable Spinner simplifies the process of implementing searchable dropdown spinners, providing a convenient solution for improved user interaction. Experience the benefits of this versatile library and enhance the usability of your Android applications today.

Spinner with searchable items.

Searchable Spinner is a dropdown spinner with a search feature that allows one to search the items loaded in the spinner.

![Demo SearchableSpinner](https://github.com/chetan532/SearchableSpinner/blob/main/video/demo.gif) 

Keywords:- 

1. Android Spinner
2. Spinner Library
3. Searchable Spinner
4. Search in the Spinner
5. Dropdown Searchable Spinner
6. Filtering Items Using Searchable Spinner

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

Set Listner SetOnItemSelectedListener
```java

searchableSpinner.setOnItemSelectedListener(object : OnItemSelectedListener {
                    override fun onItemSelected(view: View?, position: Int, id: Long) {
                        Toast.makeText(
                            this@MainActivity,
                            "Item on position " + position + " : " + adapter.getItem(
                                position
                            ) + " Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected() {
                        Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT)
                            .show()
                    }

                })

```
