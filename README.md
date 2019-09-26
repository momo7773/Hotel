# Hotel
complete the logic code and test code.

Testing MobileTime class, NewYork Time class, London Time class, Mosow Time Class, Sydney Time Class and Beijing Time Class.
Method mobileTime.changeTime, UtcTime.adjustBasedOnMobile and all the methods named 'adjust' in different class, including NewYork Time class, London Time class,
Mosow Time Class, Sydney Time Class and Beijing Time Class are tested.

City Time Class is inherted from UTCTime.

Haven't use mockito package because in practical call of methods, there are no interactions which depend on outside response. All the dependencies are just classes, which will not last for more than 1 seconds. Hence, such call of classes does not violate the rule of unit test and so choose not to use mockito.
