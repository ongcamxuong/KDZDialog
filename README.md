KDZDialog
-----
KDZDialog is an Open Source Android library that allows developers to easily create dialog like iOS.
Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.
Support Sdk Version 10 to lastest.

Feature
-----
- set Dismiss dialog in Negative or Positive.
- set Title, Message for dialog.
- The UI are like iOS dialog

![alt text](/screenshot/screenshot_0001.png)
![alt text](/screenshot/screenshot_0002.png)

How to use
-----
    Download this project and import library in there.

1. Create simple dialog message
-----
    final KDZDialog dialogBuilder = KDZDialog.getInstance(this);

2. Create some of properties in dialog
-----
	dialogBuilder
			.withTitle("Modal Dialog")
			.withMessage("This action cannot undo, are you sure?")
			.withPositiveButtonText("YES")
			.withNegativeButtonText("CANCEL")
			.setPositiveListener(new IPositiveListener() {
				@Override
				public void onClick() {
					Toast.makeText(getApplicationContext(), "On positive click", Toast.LENGTH_SHORT).show();
					dialogBuilder.dismiss();
				}
			})
			.setNegativeListener(new INegativeListener() {
				@Override
				public void onClick() {
					Toast.makeText(getApplicationContext(), "On negative click", Toast.LENGTH_SHORT).show();
					dialogBuilder.dismiss();
				}
			})
			.enablePositiveButton(View.VISIBLE)
			.enableNegativeButton(View.GONE);

3. Show dialog
-----
    dialogBuilder.show();

Note: 
- You can change PositiveButton's Text and NegativeButton's Text by to like:

    `dialogBuilder
                .withPositiveButtonText("YES")
                .withNegativeButtonText("CANCEL")`

- You can change Title and Message Text by to like:

    `dialogBuilder
                .withTitle("Modal Dialog")
                .withMessage("This action cannot undo, are you sure?")`
				
- You can enable or disable button:

    `dialogBuilder
                .enablePositiveButton(View.VISIBLE)
                .enableNegativeButton(View.GONE)`

- You can set listener when button clicked

		`.setPositiveListener(new IPositiveListener() {
			@Override
			public void onClick() {
				Toast.makeText(getApplicationContext(), "On positive click", Toast.LENGTH_SHORT).show();
				dialogBuilder.dismiss();
			}
		})
		.setNegativeListener(new INegativeListener() {
			@Override
			public void onClick() {
				Toast.makeText(getApplicationContext(), "On negative click", Toast.LENGTH_SHORT).show();
				dialogBuilder.dismiss();
			}
		})`
				
License
-------

    Copyright 2017 Ong Cam Xuong

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

