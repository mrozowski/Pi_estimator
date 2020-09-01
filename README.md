# Pi number estimator
Pi number estimator that's using random points on the Cartesian plane.
I was inspired to write this program after I watched one of Joma Tech videos on YouTube. I wanted to make that pi number estimator program and visualize it on a nice looking GUI.
I love making nice-looking designs so first I came up with this UI. I used Figma to create it.

![design](/Screenshots/Frame%201.png?raw=true "Design")

## How does it work?
First, we create random points on a Cartesian plane (like below).
Now we have to find how many points are inside a circle. Then we just need to divide number of points in the circle by all the points we have created. Because we used just on quadrant - one section from the Cartesian plane, the result must be multiplied by 4. That's it, we just estimated Pi number.

<img src="/Screenshots/axis.png?raw=true" align="center" height="500" width="500" >


## Counting distance
In this program we don't need to count exact distance from the center of Cartesian plane. We just need to know if the distance is either greater then 1 or not.

`<return ((Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2)) <= 1); >`

Here is the implementation of The Pythagorean theorem to count the distance. The method returns only boolean value: false if a distance is greater then 1 or true if it's lower or equal to 1

![program](/Screenshots/main.JPG?raw=true "main window")

I added **Avarage** button that can be found on the right side of interface. It can estimate Pi number with better aproximety due to counting avarage result from 100 test.


![program2](/Screenshots/estimation500.JPG?raw=true "program")

![program3](/Screenshots/estimation_10k.JPG?raw=true "program")

 
