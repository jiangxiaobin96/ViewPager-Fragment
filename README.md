# Newcontest
吃的比较闲，就随便写了一个宣传十九大的app，时间比较紧也没有什么框架，主题是由ViewPager+Fragment组成。
对fragment的监听器，监听是否划到该fragment
class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

在第一个fragment中使用了viewGroup的图片轮播，但是有点卡，我不知道为什么，这个框架主要是慕课网上的代码，详情参照 http://www.imooc.com/learn/793
在第三个fragment中使用了Android最好的Chart（没有之一），个人觉得很容易上手也很好玩，在这感谢shineflowers的csdn博客，也欢迎大家学习http://blog.csdn.net/shineflowers/article/details/44701645

除了这两个比较有意思的，其他就没有什么了，都是基础如有建议，欢迎赐教。
