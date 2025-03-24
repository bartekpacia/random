def new_name(name, names=[]):
  print('Hello, %s' % name)
  names.append(name)
  print('added new name %s to list, list is now: %s' % (name, names))

new_name('Bartek')
new_name('Ola')
