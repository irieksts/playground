require 'java'
import 'me.irieksts.playground.jruby.permgen.MyClass';

def test()
  myList = Array.new
  myClass = MyClass.new
  myClass.setName('name')
  myClass.setMyMap([])
  myList << myClass
  return myList
end
